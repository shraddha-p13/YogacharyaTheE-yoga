export class InstructorCourseDetails {
    private courseId: string;
    private instructorId: string;
    private courseLink: string;

    constructor(courseId: string, instructorId: string, courseLink: string) {
        this.courseId = courseId;
        this.instructorId = instructorId;
        this.courseLink = courseLink;
    }
}