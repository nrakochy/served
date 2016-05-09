(ns served.server.cli-options-test
  (:require [clojure.test :refer :all])
  (:require [served.server.cli-options :refer :all]))

(deftest set-options-return-values
  (testing "#set-options"
   (testing "default port value" 
     (is (= {:port 5000} (set-options []))))
   (testing "command line arguments" 
     (testing "correctly formatted arg" 
       (let [arg (seq '("-p" "7000"))]
       (is (= {:port 7000} (set-options arg)))))

     (testing "correctly formatted custom arg with nonesense arg correctly returns custom arg" 
     (let [arg (seq '("-p" "7000" "-nothing" "TEST"))]
       (is (= {:port 7000} (set-options arg)))))

     (testing "nonesense arg returns default arg" 
     (let [arg (seq '("-nothing" "TEST"))]
       (is (= {:port 5000} (set-options arg)))))
)))

