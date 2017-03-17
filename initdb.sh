echo Creating postgres container
docker run --name sunnary -p 5432:5432 -d postgres
echo Waiting for container startup
sleep 5
echo Creating sunnary db
createdb -h localhost -p 5432 -U postgres sunnary
