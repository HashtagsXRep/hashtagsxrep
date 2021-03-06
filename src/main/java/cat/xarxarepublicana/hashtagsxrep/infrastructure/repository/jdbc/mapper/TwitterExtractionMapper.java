package cat.xarxarepublicana.hashtagsxrep.infrastructure.repository.jdbc.mapper;

import cat.xarxarepublicana.hashtagsxrep.domain.extraction.TwitterExtraction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TwitterExtractionMapper {
  void insert(@Param("extraction") TwitterExtraction twitterExtraction, @Param("ranked") Boolean ranked);

  void deleteDataByMonitorId(@Param("monitorId") String monitorId);
}
