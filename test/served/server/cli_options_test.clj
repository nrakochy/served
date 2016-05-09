(ns served.server.cli-options-test
  (:require [clojure.test :refer :all])
  (:require [served.server.cli-options :refer :all]))

(deftest set-options-return-values
  (testing "#set-options"
   (testing "default port value" 
    (is (= {:port 5000} (set-options []))
))))

