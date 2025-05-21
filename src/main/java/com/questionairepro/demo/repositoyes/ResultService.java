package com.questionairepro.demo.repositoyes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionairepro.demo.models.UserResultModel;

@Service
public class ResultService {
    @Autowired
    ResultRepo resultrepo;

    public ResultRepo getresultrepo() {
        return resultrepo;
    }
    public void saveResultPlain(UserResultModel res)
    {
        if(resultrepo.existsByUID(res.getUID()))
        {
            long id=resultrepo.findByUID(res.getUID()).get().getResultid();
            res.setResultid(id);
        }
        resultrepo.save(res);
    }

    public void saveResultWRank(UserResultModel res) {

        try {
            if (resultrepo.existsByUID(res.getUID())) {
                UserResultModel oldres = resultrepo.findByUID(res.getUID()).get();
                if (oldres.getMarksobtained() != res.getMarksobtained()) {
                    oldres.setMarksobtained(res.getMarksobtained());
                    // overwrite marks if exists this is my design
                    resultrepo.save(oldres);
                    // we are saving it twice bceause once we save result into DB , then we can
                    // calculate rank for all making others push or pull up or below
                    calculateAndSaveRanksInBulk();
                }
            } else {
                resultrepo.save(res);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public long calculateAndReturnRank(UserResultModel newResultModel) {
        int rank = 0;
        var oldresults = resultrepo.getResultsByOrder();
        if (oldresults.size()<2) {
            return 1;
        }

        else {

            for (UserResultModel userResultModel : oldresults) {
                rank++;
                if (userResultModel.getResultid() == newResultModel.getResultid()) {
                    return rank;
                }
            }
            return rank;

        }

    }

    public void calculateAndSaveRanksInBulk() {
        var oldresults = resultrepo.getResultsByOrder();
        int rank = 0;
        for (int i = 0; i < oldresults.size(); i++) {
            rank++;
            oldresults.get(i).setRankobtained(rank);
        }
        // this function will update not add since we maintain older ResultID
        resultrepo.saveAll(oldresults);

    }

    public void setresultrepo(ResultRepo resultrepo) {
        this.resultrepo = resultrepo;

    }

    public ResultService() {
    }

}
