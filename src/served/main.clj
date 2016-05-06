(ns served.main
  (:require [org.httpkit.server :refer [run-server]]
	    [served.app.core :refer [handler]]
	    [served.server.cli-options :refer [set-options]])
  (:gen-class))

(defn -main [& args]
  (println "Server starting")
  (let [options (set-options args)]
  (run-server handler options))) 



