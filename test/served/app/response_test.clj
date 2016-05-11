(ns served.app.response-test
  (:require [clojure.test :refer :all])
  (:require [served.app.response :refer :all]))

(deftest paths-test 
  (testing "returns a sequence of :path keys"
    (let [routes [{:test "test" :path "/"} {:test1 "test1" :path "/test1"}]] 
    (let [result (lazy-seq '("/" "/test1"))]
    (println (str result))
    (is (= result (paths routes)))))
  )
)
