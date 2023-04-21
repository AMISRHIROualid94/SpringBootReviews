package com.oualid.ManyToManyBidirectional.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "STREAMS_TAB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stream {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "streams")
    private List<Viewer> viewers = new ArrayList<>();

    public Stream(String name){
        this.name = name;
    }
    public void addViewers(Viewer viewer){
        viewers.add(viewer);
    }

}
