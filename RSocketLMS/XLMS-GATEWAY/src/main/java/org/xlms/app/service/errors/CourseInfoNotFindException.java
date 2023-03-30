package org.xlms.app.service.errors;

public class CourseInfoNotFindException extends RuntimeException {
    private static final long serialVersionUID = 1L;
        public CourseInfoNotFindException() {
            super("Data requested not find");
        }

}

