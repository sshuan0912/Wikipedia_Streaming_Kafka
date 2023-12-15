package com.jessicahuan.wikimediastreamingdatapublishconsumeproject.Repository;

import com.jessicahuan.wikimediastreamingdatapublishconsumeproject.Entity.WikimediaChangedData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikimediaRepository extends JpaRepository<WikimediaChangedData, Long> {
}
