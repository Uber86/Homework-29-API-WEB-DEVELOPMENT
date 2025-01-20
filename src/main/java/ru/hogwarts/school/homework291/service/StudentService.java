package ru.hogwarts.school.homework291.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.homework291.model.Avatar;
import ru.hogwarts.school.homework291.model.Student;
import ru.hogwarts.school.homework291.repositories.AvatarRepository;
import ru.hogwarts.school.homework291.repositories.StudentRepository;
import ru.hogwarts.school.homework291.repositories.StudentsByCategory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
public class StudentService {

    Logger logger  = LoggerFactory.getLogger(StudentService.class);

    @Value("${path.to.avatars.folder}")
    private String avatarsDir;


    private final StudentRepository studentRepository;
    private final AvatarRepository avatarRepository;

    public StudentService(StudentRepository studentRepository, AvatarRepository avatarRepository) {
        this.studentRepository = studentRepository;
        this.avatarRepository = avatarRepository;
    }

    public Student create(Student student) {
        logger.info("Was invoked method for create student");
        return studentRepository.save(student);

    }

    public Student get(long id) {
        logger.info("Was invoked method for get student");
        return studentRepository.findById(id).get();
    }

    public Student update(Student student) {
        logger.info("Was invoked method for update student");
        if (!studentRepository.existsById(student.getId())){
            throw new ErrorResponseException(HttpStatusCode.valueOf(404));
        }
        return studentRepository.save(student);
    }

    public void delete(long id) {
        logger.info("Was invoked method for delete student");
        studentRepository.deleteById(id);
    }

    public Collection<Student> findAge(int age) {
        return studentRepository.findByAge(age);
    }


    public Collection<Student> findBetween(int min, int max) {
        logger.info("Was invoked method for findBetween student");
        return studentRepository.findByAgeBetween(min, max);
    }

    public Avatar findAvatar(long studentId) {
        logger.info("Was invoked method for findAvatar student");
        return avatarRepository.findByStudentId(studentId).orElseThrow();
    }

    public void uploadAvatar(Long studentId, MultipartFile file) throws IOException {
        logger.info("Was invoked method for uploadAvatar student");
        Student student = get(studentId);

        Path filePath = Path.of(avatarsDir, studentId + "." + getExtension(file.getOriginalFilename()));
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);

        try (InputStream is = file.getInputStream();
             OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
             BufferedInputStream bis = new BufferedInputStream(is, 1024);
             BufferedOutputStream bos = new BufferedOutputStream(os, 1024);
        ) {
            bis.transferTo(bos);
        }

        Avatar avatar = avatarRepository.findByStudentId(studentId).orElseGet(Avatar::new);
        avatar.setStudent(student);
        avatar.setFilePath(filePath.toString());
        avatar.setFileSize(file.getSize());
        avatar.setMediaType(file.getContentType());
        avatar.setData(file.getBytes());

        avatarRepository.save(avatar);
    }

    private String getExtension(String fileName) {
        logger.info("Was invoked method for getExtension student");
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    public List<StudentsByCategory> getStudentsAvg (){
        logger.info("Was invoked method for getStudentsAvg student");
        return studentRepository.getStudentsAvg();
    }

    public Long getStudentsQuantity(){
        logger.info("Was invoked method for getStudentsQuantity student");
        return studentRepository.getStudentsQuantity();
    }

    public List<StudentsByCategory> getStudentsDesc(){
        logger.info("Was invoked method for getStudentsDesc student");
        return studentRepository.getStudentsDesc();
    }

    public List<Student> getAvatarPage(Integer pageNumber, Integer pageSize) {
        logger.info("Was invoked method for getAvatarPage student");
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return studentRepository.findAll(pageRequest).getContent();
    }


}
