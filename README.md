# SQAT-Selenium-Exercise

This repositiory contains a project for the (SQAT)[https://jacksonfurrier.github.io/SQAT/]  ELTE-Msc course. The website under test is http://liftzone.hu/.

## Running the tests

1. Setup [docker](https://www.docker.com/) and [gradle](https://gradle.org/) on your machine.
2. Clone this repo `git clone https://github.com/IModer/SQAT-Selenium-Exercise.git`
3. Navigate to the repo and start docker compose with the following command `docker compose up`
4. Connect to the compose and with `docker exec -it <...>` where `<...>` is the name of your instance
5. run `cd tests && gradle test`