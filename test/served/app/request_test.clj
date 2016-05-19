(ns served.app.request-test
  (:require [clojure.test :refer :all])
  (:require [served.app.request :refer :all]))

(deftest lookup-route-test 
  (testing "returns a hash with an additional :matching-route key + matching route value" 
    (let [request {:uri "/test"}] 
    (let [routes [{:path "/test" :test-data "test-data"} {:path "/" :test-data "test"} {:path "/test2" :test "test"}]]
    (let [result {:uri "/test" :matching-route {:path "/test" :test-data "test-data"}}]
    (is (= result (lookup-route request routes)))))))
)

