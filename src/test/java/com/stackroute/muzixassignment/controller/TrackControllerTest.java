package com.stackroute.muzixassignment.controller;
        import com.fasterxml.jackson.databind.ObjectMapper;
        import com.stackroute.muzixassignment.model.Track;
        import com.stackroute.muzixassignment.exceptions.TrackAlreadyExistsException;
        import com.stackroute.muzixassignment.service.TrackService;
        import org.junit.Before;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.mockito.InjectMocks;
        import org.mockito.MockitoAnnotations;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
        import org.springframework.boot.test.mock.mockito.MockBean;
        import org.springframework.http.MediaType;
        import org.springframework.test.context.junit4.SpringRunner;
        import org.springframework.test.web.servlet.MockMvc;
        import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
        import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
        import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
        import org.springframework.test.web.servlet.setup.MockMvcBuilders;
        import java.util.ArrayList;
        import java.util.List;

        import static org.mockito.ArgumentMatchers.*;
        import static org.mockito.Mockito.when;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class TrackControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private Track track;
    @MockBean
    private TrackService trackService;
    @InjectMocks
    private TrackController trackController;

    private List<Track> list =null;

    @Before
    public void setUp(){

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(trackController).build();
        track = new Track();
        track.setId(101);
        track.setName("Jonny");
        track.setComments("Track records");
        list = new ArrayList();
        list.add(track);
    }

    @Test
    //	method to check save() method of controller

    public void saveTrack() throws Exception {
        when(trackService.saveTrack(any())).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/trackservice")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print());


    }
    @Test
    //	method to check save failure method of controller

    public void saveTrackFailure() throws Exception {
        when(trackService.saveTrack(any())).thenThrow(TrackAlreadyExistsException.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/trackservice")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(status().isConflict())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    //	method to check get all tracks() method of controller

    public void getAllTracks() throws Exception {
        when(trackService.getAllTrack()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/trackservice")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

@Test
//	method to check update() method of controller
    public void updateTrack() throws Exception {
    Track track1 = new Track(1,"testcase","testcomment");
    when(trackService.updateTrack(anyInt(), any())).thenReturn(track1);
    mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/trackservice/1")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .content(asJsonString(track)))
            .andExpect(status().isOk());
}
    @Test
    //	method to check delete() method of controller
    public void deleteTrack() throws Exception {
        when(trackService.deleteTrack(anyInt())).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/trackservice/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(track)))
                .andExpect(status().isOk());
    }
    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
