package cat.xarxarepublicana.hashtagsxrep.domain.invite;

import cat.xarxarepublicana.hashtagsxrep.domain.user.User;
import java.util.ArrayList;
import java.util.List;

public class InviteGroup {

  private final List<Invite> adminList;
  private final List<Invite> taggerList;
  private final List<Invite> influenceList;
  private final List<Invite> topRankingList;
  private final List<Invite> randomRankingList;

  public InviteGroup(
      List<Invite> adminList,
      List<Invite> taggerList,
      List<Invite> influenceList,
      List<Invite> topRankingList,
      List<Invite> randomRankingList) {
    this.adminList = adminList != null ? adminList : new ArrayList<>();
    this.taggerList = taggerList != null ? taggerList : new ArrayList<>();
    this.influenceList = influenceList != null ? influenceList : new ArrayList<>();
    this.topRankingList = topRankingList != null ? topRankingList : new ArrayList<>();
    this.randomRankingList = randomRankingList != null ? randomRankingList : new ArrayList<>();
  }

  public List<Invite> getAdminList() {
    return adminList;
  }

  public List<Invite> getTaggerList() {
    return taggerList;
  }

  public List<Invite> getInfluenceList() {
    return influenceList;
  }

  public List<Invite> getTopRankingList() {
    return topRankingList;
  }

  public List<Invite> getRandomRankingList() {
    return randomRankingList;
  }

  public boolean isInvited(User user) {
    return isAdmin(user) || isTop(user) || isRandom(user) || isTagger(user) || isInfluencer(user);
  }

  private boolean isRandom(User user) {
    return randomRankingList.stream()
        .anyMatch(invite -> user.getNickname().equals(invite.getNickname()));
  }

  private boolean isTop(User user) {
    return topRankingList.stream()
        .anyMatch(invite -> user.getNickname().equals(invite.getNickname()));
  }

  private boolean isInfluencer(User user) {
    return influenceList.stream()
        .anyMatch(invite -> user.getNickname().equals(invite.getNickname()));
  }

  private boolean isTagger(User user) {
    return taggerList.stream()
        .anyMatch(invite -> user.getNickname().equals(invite.getNickname()));
  }

  private boolean isAdmin(User user) {
    return adminList.stream()
        .anyMatch(invite -> user.getNickname().equals(invite.getNickname()));
  }
}
