(ns served.app.request)

(def routes 
  {:resources {:name "employees" :methods [:get, :post] :parent_path "company"}
	      {:name "company" :methods [:get, :post]} 
	      {:name "dashboard" :root_path true} }
)

(defn compile-routes 
   (-> routes
      associate-path 
   )
)

(defn associate-path [resource path]
  (assoc resource :path path)
)

(defn add-paths [route-map]
  (map 
    #(if (contains? % :root_path)
      (associate-path % "/")
      (associate-path % (str "/" (get % :name)))
     ) route-map)
)

(def routes-registry (compile-routes)) 

(defn identify-resource [uri-path]
)

(defn parse-request [request]
)



