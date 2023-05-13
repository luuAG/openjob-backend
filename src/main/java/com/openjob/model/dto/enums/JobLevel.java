package com.openjob.model.dto.enums;

import lombok.Getter;

@Getter
public enum JobLevel {
    INTERN("Thực tập"),
    FRESHER("Fresher"),
    JUNIOR("Junior"),
    MIDDLE("Middle"),
    SENIOR("Senior"),
    LEADER("Trưởng nhóm"),
    PROJECT_MANAGER("Quán lý dự án"),
    HIGH_POSITION("Vị trí cao câp");

    private final String value;

    JobLevel(String s) {
        value = s;
    }
    public static JobLevel fromValue(String value) {
        for (JobLevel jobLevel : JobLevel.values()) {
            if (jobLevel.getValue().equals(value)) {
                return jobLevel;
            }
        }
        throw new IllegalArgumentException("No enum JobLevel found with value: " + value);
    }
}
