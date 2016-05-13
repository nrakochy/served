(ns served.app.response-test
  (:require [clojure.test :refer :all])
  (:require [served.app.response :refer :all]))

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

(deftest requested-method-not-allowed 
  (testing "returns nil if a requested route uses method not allowed"
    (let [matching-route {:test "test" :path "/" :methods [:get :post]}] 
    (let [request {:uri "/" :request-method :delete}] 
    (is (= nil (requested-method request matching-route)))))
  )
)

(deftest requested-method-allowed 
  (testing "returns matching method if request-method is permitted"
    (let [matching-route {:test "test" :path "/" :methods [:get :post]}] 
    (let [request {:uri "/" :request-method :post}] 
    (is (= :post (requested-method request matching-route)))))
  )
)







