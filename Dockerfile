FROM adoptopenjdk/openjdk13:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=riel_lviv_bot
ENV BOT_TOKEN=949771233:AAEdyazNPpiVxss8YtzEoLj_ck75dDMLQ5U
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]
