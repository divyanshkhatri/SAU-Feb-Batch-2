# NoSQL Basics And Fundamentals Assignment

### A pdf file is attached which contains the solutions for the Couchbase Assignment.

### Following commands have been used - 

1. To add a bucket into couchbase, 

``` 
./couchbase-cli bucket-create -c couchbase://127.0.0.1 --username 'your username' \ --password 'your password' --bucket 'bucket name' --bucket-type couchbase \ --bucket-ramsize 1024
```
2. To perform a cbexport on the bucket,

```
./cbexport json -c couchbase://127.0.0.1 -u "your username" -p "your password" -b "bucket-name" -o /Users/divyanshkhatri/Desktop/beer-sample-cbexport.json -f lines -t 4 --scope-field couchbaseScope --
collection-field couchbaseCollection
```
3. To perform a cbimport into the bucket,

```
./cbimport json -c couchbase://127.0.0.1 -u "your username" -p "your-password" -b Beer -f lines -d file://Users/divyanshkhatri/Desktop/beer-sample-cbexport.json -t 4 -g %primary_key%
```
