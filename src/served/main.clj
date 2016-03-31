(ns served.main
  (:require [ring.adapter.jetty :refer [run-jetty]]
	    [served.core :refer [handler]])
  (:gen-class))

(defn -main [& options]
  (run-jetty handler {:port 5000}))

