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

(deftest requested-method-not-allowed 
  (testing "returns nil if a requested route uses method not allowed"
    (let [matching-route {:test "test" :path "/" :methods [:get :post]}] 
    (let [request {:uri "/" :request-method :delete :matching-route matching-route}] 
    (is (= nil (requested-method request)))))
  )
)

(deftest requested-method-allowed 
  (testing "returns matching method if request-method is permitted"
    (let [matching-route {:test "test" :path "/" :methods [:get :post]}] 
    (let [request {:uri "/" :request-method :post :matching-route matching-route}] 
    (is (= :post (requested-method request)))))
  )
)







