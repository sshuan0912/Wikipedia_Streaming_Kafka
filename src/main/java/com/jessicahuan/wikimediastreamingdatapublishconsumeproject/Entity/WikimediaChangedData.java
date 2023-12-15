package com.jessicahuan.wikimediastreamingdatapublishconsumeproject.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wikimediaChangedMessage")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WikimediaChangedData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Lob
    @Column(name = "changedData", length = 10000000)
    private String changedData;


}
