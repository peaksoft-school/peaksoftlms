package kg.peaksoftlms.peaksoftlms.testPackage.service.lesson.impl;

import kg.peaksoftlms.peaksoftlms.testPackage.dto.lesson.VideoRequest;
import kg.peaksoftlms.peaksoftlms.testPackage.dto.lesson.VideoResponse;
import kg.peaksoftlms.peaksoftlms.testPackage.service.lesson.VideoService;
import kg.peaksoftlms.peaksoftlms.testPackage.model.lesson.Lesson;
import kg.peaksoftlms.peaksoftlms.testPackage.model.lesson.Video;
import kg.peaksoftlms.peaksoftlms.testPackage.repository.lesson.LessonRepository;
import kg.peaksoftlms.peaksoftlms.testPackage.repository.lesson.VideoRepository;
import kg.peaksoftlms.peaksoftlms.exeption.ResourceNotFoundException;
import kg.peaksoftlms.peaksoftlms.testPackage.mapper.lesson.VideoMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class VideoServiceImpl implements VideoService {

    private final LessonRepository lessonRepository;
    private final VideoRepository videoRepository;
    private final VideoMapper mapper;

    @Override
    public List<VideoResponse> getAllVideoByLessonId(Long lessonId) {
        if (!lessonRepository.existsById(lessonId)) {
            log.error("lesson with id = {} does not exists in database", lessonId);
            throw new ResourceNotFoundException("Not found lesson with this id: " + lessonId);
        }
        return mapper.videoListToVideoResponseList(videoRepository.findByLessonId(lessonId));
    }

    @Override
    public VideoResponse getById(Long id) {
        log.info("Get video with this id = {}", id);
        return mapper.videoToVideoResponse(
                videoRepository.findById(id).orElseThrow(() -> {
                    log.error("video with id = {} does not exist in database", id);
                    throw new ResourceNotFoundException("Not found video with this id: " + id);
                }));
    }

    @Override
    public VideoResponse saveNew(VideoRequest videoRequest, Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(() -> {
            log.error("lesson with id = {} does not exists in database", lessonId);
            throw new ResourceNotFoundException("Not found lesson with this id: " + lessonId);
        });
        Video video = mapper.videoRequestToVideo(videoRequest);
        video.setLesson(lesson);
        return mapper.videoToVideoResponse(videoRepository.save(video));
    }

    @Override
    public void deleteById(Long id) {
        if (!videoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Not found video with id: " + id);
        }
        videoRepository.deleteById(id);
    }

    @Override
    public VideoResponse update(Long lessonId, Long id, VideoRequest videoRequest) {
        if (!videoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Not found video with id: " + id);
        }
        Video video = videoRepository.findById(id).orElseThrow(() -> {
            log.error("video with id = {} does not exist in database", id);
            throw new ResourceNotFoundException("Not found video with this id: " + id);
        });
        mapper.update(video, videoRequest);
        return mapper.videoToVideoResponse(videoRepository.save(video));
    }
}
