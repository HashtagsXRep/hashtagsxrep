package cat.xarxarepublicana.hashtagsxrep.domain.monitor;

import java.util.List;

public interface MonitorRepository {
  void save(Monitor monitor);

  void updateCursor(Monitor monitor, String nextQueryString);

  Monitor findById(String id);

  List<Monitor> getActiveMonitors();

  String getMaxTweetId(String monitorId);

  List<Monitor> getLastMonitors();

  Monitor findByTwitterQuery(String twitterQuery);

  void disable(String id);

  void delete(Monitor monitor);
}
