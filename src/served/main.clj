(ns served.main
  (:require [org.httpkit.server :refer [run-server]]
	    [served.core :refer [handler]]
	    [clojure.tools.cli :refer [parse-opts]])
  (:gen-class))

(def cli-options
  [["-p" "--port PORT" "Port number"
    :default 5000 
    :parse-fn #(Integer/parseInt %)
    :validate [#(< 0 % 0x10000) "Must be a number between 0 and 65536"]]
   ])

(defn set-options [& args]
  (get (parse-opts args cli-options) :options))

(defn -main [& args]
  (println "Server starting")
  (run-server handler (get (parse-opts args cli-options) :options)))



