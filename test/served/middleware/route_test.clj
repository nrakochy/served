(ns served.middleware.route-test
  (:require [clojure.test :refer :all])
  (:require [served.middleware.route :refer :all]))

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
    (let [route-test 
	  [{:name "test" :methods [:get :post]}
	  {:name "test_root" :root_path true}] ] 
    (let [result 
	  [{:name "test" :methods [:get :post] :path "/test"}
	  {:name "test_root" :root_path true :path "/"}]]
    (is (= result (add-paths route-test)))))
  )
)



