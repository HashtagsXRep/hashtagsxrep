package cat.xarxarepublicana.hashtagsxrep.infrastructure.controller;

import cat.xarxarepublicana.hashtagsxrep.application.Views;
import cat.xarxarepublicana.hashtagsxrep.application.monitor.CreateMonitorUseCase;
import cat.xarxarepublicana.hashtagsxrep.application.monitor.DeleteMonitorUseCase;
import cat.xarxarepublicana.hashtagsxrep.application.monitor.ListMonitorUseCase;
import cat.xarxarepublicana.hashtagsxrep.infrastructure.security.AuthenticationUser;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MonitorController {

  private final CreateMonitorUseCase createMonitorUseCase;
  private final DeleteMonitorUseCase deleteMonitorUseCase;
  private final ListMonitorUseCase listMonitorUseCase;

  @Autowired
  public MonitorController(
      CreateMonitorUseCase createMonitorUseCase,
      ListMonitorUseCase listMonitorUseCase,
      DeleteMonitorUseCase deleteMonitorUseCase) {
    this.createMonitorUseCase = createMonitorUseCase;
    this.listMonitorUseCase = listMonitorUseCase;
    this.deleteMonitorUseCase = deleteMonitorUseCase;
  }

  @PostMapping("/monitor")
  @Secured("ROLE_ADMIN")
  public String createMonitor(
      @RequestParam("twitterQuery")
          String twitterQuery,
      @RequestParam("endTime")
      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
          LocalDateTime endTime,
      @AuthenticationPrincipal
          AuthenticationUser authenticationUser) {
    createMonitorUseCase.createMonitor(authenticationUser.getUser(), twitterQuery, endTime);
    return "redirect:/monitor";
  }

  @GetMapping("/monitor")
  public String listMonitors(Model model) {
    ListMonitorUseCase.ListMonitorResponse listMonitorResponse = listMonitorUseCase.listMonitor();
    model.addAttribute("monitorList", listMonitorResponse.getMonitorList());
    return Views.VIEW_MONITOR;
  }

  @PostMapping("/monitor/{monitorId}/delete")
  @Secured("ROLE_ADMIN")
  public RedirectView monitorDelete(
      @PathVariable("monitorId") String monitorId,
      @RequestParam("hashtag") String hashtag
  ) {
    deleteMonitorUseCase.deleteMonitor(monitorId, hashtag);
    return new RedirectView(Views.URL_MONITOR);
  }
}
