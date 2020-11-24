# Docker Dictionary

## Author
Aziz Mavlyanov

## Stack
HTML, Mustache, CSS, JavaScript, Java, Spring Boot, MongoDB, Docker

## Installation and usage of the project
**Please make sure that you have docker installed on your PC (Notebook)**

1\) Run containers from the root of the project:
```dotenv
sudo docker-compose up -d --build --force-recreate
```
2\) Visit http://localhost:8085/ and start using the dictionary

**PostgreSQL database is persistent** since data located in volume.
