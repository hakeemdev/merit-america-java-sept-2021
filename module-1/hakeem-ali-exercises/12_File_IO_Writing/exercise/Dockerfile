# Install LTS version of Java
FROM maven:3.6-openjdk-11

# Set as current directory for RUN, ADD, COPY commands
WORKDIR /app

# Add entire student fork (overwrites previously added files)
ARG SUBMISSION_SUBFOLDER
COPY $SUBMISSION_SUBFOLDER /app

# Overwrite files in student fork with upstream files
COPY src/test/java/com/techelevator /app/src/test/java/com/techelevator
COPY src/test/resources /app/src/test/resources
COPY test.sh pom.xml ./
