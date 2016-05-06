(ns served.server.cli-options
  (:require [clojure.tools.cli :refer [parse-opts]]))

(defn set-options [args]
  (let [cli-options
  [
    ["-p" "--port PORT" "Port number"
    :default 5000 
    :parse-fn #(Integer/parseInt %)
    :validate [#(< 0 % 0x10000) "Must be a number between 0 and 65536"]]
  ]] 
  (get (parse-opts args cli-options) :options)))

