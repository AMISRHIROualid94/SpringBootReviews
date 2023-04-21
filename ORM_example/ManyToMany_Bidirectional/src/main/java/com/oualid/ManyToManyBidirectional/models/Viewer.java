package com.oualid.ManyToManyBidirectional.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "VIEWERS_TAB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Viewer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nikeName;

    @ManyToMany
    @JoinTable(name = "viewers_tab_streams",
            joinColumns = @JoinColumn(name = "viewer_id"),
            inverseJoinColumns = @JoinColumn(name = "streams_id"))
    private List<Stream> streams = new ArrayList<>();


    public Viewer(String nikeName){
        this.nikeName = nikeName;
    }

    public void addStreams(Stream stream){
        streams.add(stream);
    }
}
