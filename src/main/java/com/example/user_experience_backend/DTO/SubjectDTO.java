package com.example.user_experience_backend.DTO;

import java.util.List;

public class SubjectDTO {
    private String subjectName;
    private List<ProgressDTO> progresses;

    public SubjectDTO(String subjectName, List<ProgressDTO> progresses) {
        this.subjectName = subjectName;
        this.progresses = progresses;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public List<ProgressDTO> getProgresses() {
        return progresses;
    }

    public void setProgresses(List<ProgressDTO> progresses) {
        this.progresses = progresses;
    }
}
