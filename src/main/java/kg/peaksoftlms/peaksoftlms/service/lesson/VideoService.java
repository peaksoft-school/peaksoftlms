package kg.peaksoftlms.peaksoftlms.service.lesson;

import kg.peaksoftlms.peaksoftlms.db.dto.lesson.VideoRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.lesson.VideoResponse;

import java.util.List;

public interface VideoService {
    List<VideoResponse> getAllVideoByLessonId(Long lessonId);

    VideoResponse getById(Long id);

    VideoResponse saveNew(VideoRequest videoRequest, Long lessonId);

    VideoResponse update(Long lessonId, Long id, VideoRequest videoRequest);

    void deleteById(Long id);
}
