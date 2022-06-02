# Install LTS version of Java
FROM maven:3.6-openjdk-11

# Set as current directory for RUN, ADD, COPY commands
WORKDIR /app

# Create subfolders for different Maven projects
RUN mkdir /app/client
RUN mkdir /app/server

# Add entire student fork (overwrites previously added files)
ARG SUBMISSION_SUBFOLDER
COPY $SUBMISSION_SUBFOLDER /app

# Overwrite files in student fork with upstream files
COPY client/src/test/java/com/techelevator /app/client/src/test/java/com/techelevator
COPY client/src/test/resources /app/client/src/test/resources

COPY server/src/test/java/com/techelevator /app/server/src/test/java/com/techelevator

COPY client/pom.xml /app/client
COPY server/pom.xml /app/server

COPY test.sh ./