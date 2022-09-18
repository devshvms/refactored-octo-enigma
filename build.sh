mvn clean package -DskipTests
cd target/
nohup java -jar refactored-octo-enigma-0.0.1-SNAPSHOT.jar &
