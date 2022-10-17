package school_manager.service;

public interface ISTeacherService extends IPerson {
    void addTeacher();

    void displayTeacher();

    void removeTeacher();

    void findTeacherName();

    void findTeacherCode();

    void sortTeacher();
}
