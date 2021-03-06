package cat.xarxarepublicana.hashtagsxrep.infrastructure.repository.jdbc.mapper;

import cat.xarxarepublicana.hashtagsxrep.domain.poll.Poll;
import cat.xarxarepublicana.hashtagsxrep.domain.poll.Proposal;
import cat.xarxarepublicana.hashtagsxrep.domain.user.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PollMapper {

  void insert(@Param("poll") Poll poll);

  Poll selectOneById(@Param("id") String id);

  List<Poll> selectLastStarted(@Param("quantity") Integer quantity);

  Boolean existsProposal(@Param("pollId") String pollId, @Param("authorId") String authorId);

  Proposal selectOneProposalById(@Param("pollId") String pollId, @Param("authorId") String authorId);

  Proposal selectVotedProposal(@Param("pollId") String pollId, @Param("voterId") String voterId);

  void insertProposal(@Param("proposal") Proposal proposal);

  void updateProposal(@Param("proposal") Proposal proposal);

  List<Proposal> selectProposalsList(@Param("pollId") String pollId, @Param("orderVotes") Boolean orderVotes);

  void insertVote(@Param("proposal") Proposal proposal, @Param("voter") User voter);

  List<Poll> selectFinishedPollsWithNoMonitor();

  void deleteVotes(@Param("pollId") String pollId);

  void deleteProposals(@Param("pollId") String pollId);

  void delete(@Param("pollId") String pollId);

  void deleteVote(@Param("pollId") String pollId, @Param("userId") String userId);
}
