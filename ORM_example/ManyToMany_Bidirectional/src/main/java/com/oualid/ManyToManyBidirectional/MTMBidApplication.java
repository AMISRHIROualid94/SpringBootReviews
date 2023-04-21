package com.oualid.ManyToManyBidirectional;

import com.oualid.ManyToManyBidirectional.models.Stream;
import com.oualid.ManyToManyBidirectional.models.Viewer;
import com.oualid.ManyToManyBidirectional.repositories.StreamRepository;
import com.oualid.ManyToManyBidirectional.repositories.ViewerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MTMBidApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MTMBidApplication.class,args);

        StreamRepository streamRepository = (StreamRepository) context.getBean("streamRepository");
        ViewerRepository viewerRepository = (ViewerRepository) context.getBean("viewerRepository");

        Stream stream1 = new Stream("Stream 1");
        Stream stream2 = new Stream("Stream 2");
        Stream stream3 = new Stream("Stream 3");
        Stream stream4 = new Stream("Stream 4");
        List<Stream> streams = Arrays.asList(
                stream1,
                stream2,
                stream3,
                stream4
        );
        streamRepository.saveAll(streams);

        Viewer viewer1 = new Viewer("Viewer 1");
        Viewer viewer2 = new Viewer("Viewer 2");
        Viewer viewer3 = new Viewer("Viewer 3");
        Viewer viewer4 = new Viewer("Viewer 4");
        List<Viewer> viewers = Arrays.asList(
                viewer1,
                viewer2,
                viewer3,
                viewer4
        );

        /*stream1.addViewers(viewer1);
        stream1.addViewers(viewer2);
        stream2.addViewers(viewer1);
        stream2.addViewers(viewer2);
        stream2.addViewers(viewer3);
        stream3.addViewers(viewer4);
        stream4.addViewers(viewer1);
        stream4.addViewers(viewer4);*/

        viewer1.addStreams(stream1);
        viewer1.addStreams(stream2);
        viewer2.addStreams(stream1);
        viewer2.addStreams(stream2);
        viewer2.addStreams(stream3);
        viewer3.addStreams(stream4);
        viewer4.addStreams(stream1);
        viewer4.addStreams(stream4);

        viewerRepository.saveAll(viewers);
    }
}
