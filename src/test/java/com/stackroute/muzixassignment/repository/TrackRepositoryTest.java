package com.stackroute.muzixassignment.repository;

import com.stackroute.muzixassignment.model.Track;
import org.junit.Test;
        import org.junit.After;
        import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
        import org.springframework.test.context.junit4.SpringRunner;

        import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TrackRepositoryTest {

    @Autowired
    TrackRepository trackRepository;
    Track track;

    @Before
    public void setUp()
    {
        track = new Track();
        track.setId(101);
        track.setName("John");
        track.setComments("sadsdsad Jenny");

    }

    @After
    public void tearDown(){

        trackRepository.deleteAll();
    }


    @Test
    public void testSaveUser(){
        trackRepository.save(track);
        Track fetchUser = trackRepository.findById(track.getId()).get();
        Assert.assertEquals(101,fetchUser.getId());

    }

    @Test
    public void testSaveUserFailure(){
        Track testUser = new Track(34,"Harry123","Comments");
        trackRepository.save(track);
        Track fetchUser = trackRepository.findById(track.getId()).get();
        Assert.assertNotSame(testUser,track);
    }

    @Test
    public void testGetAllUser(){
        Track u = new Track(10,"Johny","abc");
        Track u1 = new Track(11,"Harry","efg");
        trackRepository.save(u);
        trackRepository.save(u1);

        List<Track> list = trackRepository.findAll();
        Assert.assertEquals("Johny",list.get(0).getName());

    }
    @Test
    public void updateTrackTest()
    {
        Track track=new Track(106,"Update","UpdatingTracks");
        trackRepository.save(track);
        trackRepository.findById(track.getId()).get().setName("UpdatedTrackInName");
        List<Track> list=trackRepository.findAll();
        Assert.assertEquals("UpdatedTrackInName",list.get(0).getName());
    }

    @Test
    public void deleteTrackTest()
    {
        Track track=new Track(107,"Delete","DeleteTrack");
        trackRepository.save(track);
        trackRepository.deleteById(107);
        boolean result=trackRepository.existsById(107);
        Assert.assertEquals(false,result);

    }

}