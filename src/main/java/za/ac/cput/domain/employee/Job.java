/*
    Job.java
    Job domain
    Name: Ian Louw
    Student number: 216250773
 */

package za.ac.cput.domain.employee;

import java.io.Serializable;

public class Job implements Serializable {

    private String jobId;
    private String jobName;
    private String jobDescription;

    public Job() {
    }

    private Job (Builder builder) {
        this.jobId = builder.jobId;
        this.jobName = builder.jobName;
        this.jobDescription = builder.jobDescription;
    }

    public String getJobId() {
        return jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", jobName='" + jobName + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                '}';
    }

    public static class Builder {

        private String jobId, jobName, jobDescription;

        public Builder setJobName(String jobName) {
            this.jobName = jobName;

            return this;
        }

        public Builder setJobDescription(String jobDescription) {
            this.jobDescription = jobDescription;

            return this;
        }

        public Builder setJobId(String jobId) {
            this.jobId = jobId;

            return this;
        }

        public Job build () {
            return new Job(this);
        }

        public Builder copy(Job job) {
            this.jobId = job.jobId;
            this.jobName = job.jobName;
            this.jobDescription = job.jobDescription;

            return this;
        }
    }
}
