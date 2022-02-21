package kg.peaksoftlms.peaksoftlms.mapper.lesson;

import kg.peaksoftlms.peaksoftlms.db.dto.lesson.VideoRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.lesson.VideoResponse;
import kg.peaksoftlms.peaksoftlms.db.model.lesson.Video;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class VideoMapper {
    private final ModelMapper modelMapper;

    public VideoResponse videoToVideoResponse(Video video) {
        VideoResponse videoResponse = new VideoResponse();
        modelMapper.map(video, VideoResponse.class);
        return videoResponse;
    }

    public List<VideoResponse> videoListToVideoResponseList(List<Video> videoList) {
        return videoList.stream().map(this::videoToVideoResponse).collect(Collectors.toList());
    }

    public Video videoRequestToVideo(VideoRequest videoRequest) {
        return modelMapper.map(videoRequest, Video.class);
    }

    public void update(Video video, VideoRequest videoRequest) {
        video.setName(videoRequest.getName());
        video.setVideo(video.getVideo());
        video.setDescription(videoRequest.getDescription());
    }
}
