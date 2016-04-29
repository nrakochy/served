(ns served.main
  (:require [org.httpkit.server :refer [run-server]]
	    [served.core :refer [handler]])
  (:gen-class))

(defn -main [& options]
  (run-server handler options))

