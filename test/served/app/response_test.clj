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

(deftest invalid-path?-test-true 
  (testing "returns true if request uri is not included in routes-map"
    (let [routes [{:test "test" :path "/"} {:test1 "test1" :path "/test1"}]] 
    (let [request  {:uri "/missing" :server-name "localhost"} ] 
    (is (= true (invalid-path? request routes)))))
  )
)

(deftest invalid-path?-test-false 
  (testing "returns false if request uri is not included in routes-map"
    (let [routes [{:test "test" :path "/"} {:test1 "test1" :path "/test1"}]] 
    (let [request  {:uri "/test1" :server-name "localhost"} ] 
    (is (= false (invalid-path? request routes)))))
  )
)

(deftest allowed-methods-test-default 
  (testing "returns a list with :get as the default method available to endpoints"
    (let [route {:test "test" :path "/"}] 
    (let [result '(:get)]
    (is (= result (allowed-methods route)))))
  )
)

(deftest allowed-methods-test-with-defined-methods 
  (testing "returns a list of defined methods from a given route"
    (let [route {:test "test" :path "/" :methods [:get :post]}] 
    (let [result '(:get :post)]
    (is (= result (allowed-methods route)))))
  )
)

(deftest extract-matching-route-test 
  (testing "returns requested route from routes-map"
    (let [request {:uri "/" :name "test"}] 
    (let [result {:name "test" :path "/"}] 
    (let [available-routes 
      [result {:name "test1" :path "/test1"} {:name "test2" :path "/test2"}]]
    (is (= result (extract-matching-route request available-routes))))))
  )
)

(deftest extract-matching-route-test-no-match-found 
  (testing "returns nil from routes-map if no match found"
    (let [request {:uri "/missing-test" :name "test"}] 
    (let [available-routes 
      [{:name "test" :path "/"} {:name "test1" :path "/test1"} {:name "test2" :path "/test2"}]]
    (is (= nil (extract-matching-route request available-routes)))))
  )
)



