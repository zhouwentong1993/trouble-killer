for i in {1..200}
do
    curl localhost:8080/test/go
    echo $i
done
