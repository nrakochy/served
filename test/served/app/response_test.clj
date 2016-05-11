(ns served.app.response-test
  (:require [clojure.test :refer :all])
  (:require [served.app.response :refer :all]))

(deftest paths-test 
  (testing "returns a sequence of :path keys"
    (let [routes [{:test "test" :path "/"} {:test1 "test1" :path "/test1"}]] 
    (let [result (lazy-seq '("/" "/test1"))]
    (is (= result (paths routes)))))
  )
)

(deftest valid-path?-test-true 
  (testing "returns true if request uri is included in routes-map"
    (let [routes [{:test "test" :path "/"} {:test1 "test1" :path "/test1"}]] 
    (let [request  {:uri "/test1" :server-name "localhost"} ] 
    (is (= true (valid-path? request routes)))))
  )
)

(deftest valid-path?-test-false 
  (testing "returns false if request uri is included in routes-map"
    (let [routes [{:test "test" :path "/"} {:test1 "test1" :path "/test1"}]] 
    (let [request  {:uri "/missing" :server-name "localhost"} ] 
    (is (= false (valid-path? request routes)))))
  )
)



