package school_manager.service;

public interface IStudentService extends IPerson {
    void addStudent();

    void displayAllStudent();
    void removeStudent();
    void findStudyName();
    void findStudyCode();
    void sortStudy();
}
