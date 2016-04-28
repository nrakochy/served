(ns served.main
  (:require [ring.adapter.jetty :refer [run-jetty]]
	    [served.core :refer [runner])
  (:gen-class))

(defn -main [handler & options]
  (run-jetty handler options))

