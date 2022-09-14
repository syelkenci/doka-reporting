FROM maven:3.8.4-openjdk-17 AS builder

COPY pom.xml /src/pom.xml
COPY mvn-settings.xml /src/settings.xml

WORKDIR /src

COPY . /src/

RUN --mount=type=cache,target=/root/.m2 mvn -s /src/settings.xml package -DskipTests

FROM openjdk:17-oracle AS runner

COPY --from=builder /src/target/*-SNAPSHOT.jar /app/doka-reporting.jar

ENTRYPOINT [ "java", \
            "-Delastic.apm.service_name=doka-reporting", \
            "-Delastic.apm.application_packages=com.doka.dokareporting", \
            "-Delastic.apm.server_url=http://apm-server-apm-server.monitoring:8200", \
            "-Delastic.apm.trace_methods=com.doka.dokareporting.service.*", \
            "-jar", \
            "/app/doka-reporting.jar" \
]