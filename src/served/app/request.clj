(ns served.app.request)

(defn employees [])
(defn company [])
(defn dashboard [])

(def routes 
  [{:name employees :methods [:get, :post] :parent_path "company"}
   {:name company :methods [:get, :post]} 
   {:name dashboard :root_path true}]
)

(defn compile-routes []
   ;;(-> routes
   ;;   add-paths 
   ;;)
)

(defn associate-path [resource path]
  (assoc resource :path path)
)

(defn add-paths [route-map]
  (map 
    #(if (contains? % :root_path)
      (associate-path % "/")
      (associate-path % (str "/" (name (get % :name))))
     ) route-map)
)

(defn routes-registry [] (compile-routes)) 

(defn identify-resource [uri-path]
)

(defn parse-request [request]
)



