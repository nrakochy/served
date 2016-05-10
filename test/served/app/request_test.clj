(ns served.app.request-test
  (:require [clojure.test :refer :all])
  (:require [served.app.request :refer :all]))

(deftest associate-path-test 
  (testing "Appends a :path key and path string value to a given hash"
    (let [resource {:test "test"}]
    (let [path "/test"]
    (let [result {:test "test" :path "/test"}]
    (is (= result (associate-path resource path))))))
  )
)

(deftest add-paths-test 
  (testing "Returns a hash with a :path key value appended to each record"
    (let [test_method1 ((defn example []))]
    (let [test_method2 ((defn example_root []))]
    (let [route-test 
	  [{:name test_method1 :methods [:get, :post]}
	  {:name test_method2 :root_path true}] ] 
    (let [result 
	  [{:name test_method1 :methods [:get, :post] :path "/test"}
	  {:name test_method2 :root_path true :path "/"}]]
    (is (= result (add-paths route-test)))))))
  )
)



