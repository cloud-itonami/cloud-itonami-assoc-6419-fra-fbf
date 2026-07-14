(ns association.facts
  "Industry self-regulatory rule catalog for the Fédération Bancaire
  Française (FBF, French Banking Federation) -- a 9th industry-
  association-level source (see cloud-itonami-assoc-6419-jpn-zenginkyo,
  -6512-jpn-sonpo, -6612-jpn-jsda, -6419-deu-bankenverband,
  -6612-usa-finra, -6512-usa-naic, -6920-jpn-jicpa, -6920-usa-aicpa for
  the first eight) per ADR-2607141700
  (cloud-itonami-compliance-fact-federation). Aligned to ISIC 6419
  (banking) -- the SAME ISIC code as zenginkyo (JPN) and bankenverband
  (DEU), extending the banking-association comparison to a THIRD country.
  Every entry cites an OFFICIAL fbf.fr URL -- never fabricated. A rule
  not in this table has NO spec-basis, full stop; extend `catalog`, do
  not invent an id/url.

  Both entries below were directly WebFetch-verified against the live
  fbf.fr page on 2026-07-15.")

(def catalog
  "assoc-slug -> vector of self-regulatory rule entries."
  {"fbf"
   [{:association-rule/id "fbf.regles-professionnelles"
     :association-rule/title "Règles professionnelles (Professional Rules)"
     :association-rule/association "fbf"
     :association-rule/isic "6419"
     :association-rule/country "FRA"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.fbf.fr/fr/la-federation/regles-professionnelles/"
     :association-rule/url-provenance :official-association-site
     :association-rule/retrieved-at "2026-07-15"
     :association-rule/topic #{:governance}}
    {:association-rule/id "fbf.normes-professionnelles"
     :association-rule/title "Normes professionnelles (Professional Standards, binding on all member institutions)"
     :association-rule/association "fbf"
     :association-rule/isic "6419"
     :association-rule/country "FRA"
     :association-rule/kind :self-regulatory-code
     :association-rule/url "https://www.fbf.fr/fr/la-federation-bancaire-francaise/regles-professionnelles/normes-professionnelles/"
     :association-rule/url-provenance :official-association-site
     :association-rule/retrieved-at "2026-07-15"
     :association-rule/topic #{:consumer-protection :fair-transaction}}]})

(defn spec-basis [assoc-slug] (get catalog assoc-slug))

(defn coverage
  ([] (coverage (keys catalog)))
  ([slugs]
   (let [have (filter catalog slugs)
         missing (remove catalog slugs)]
     {:requested (count slugs)
      :covered (count have)
      :covered-associations (vec (sort have))
      :missing-associations (vec (sort missing))
      :note (str "cloud-itonami-assoc-6419-fra-fbf Wave 0 (ADR-2607141700): "
                 (count (get catalog "fbf")) " fbf rules seeded with an "
                 "official fbf.fr citation. Extend "
                 "`association.facts/catalog`, never fabricate a rule id/url.")})))

(defn by-topic [assoc-slug topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis assoc-slug)))
