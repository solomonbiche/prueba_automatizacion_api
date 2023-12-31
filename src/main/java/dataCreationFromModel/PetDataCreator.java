package dataCreationFromModel;

import dataModel.PetP;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.HashMap;

public class PetDataCreator
{
    public static PetP pet = new PetP();
    public static Faker fake = new Faker();

    public PetP petDataforUpdate(int petID)
    {
        pet = new PetP();
        HashMap<String, String> categoryMap = new HashMap<String, String>();
        categoryMap.put("id", "1");
        categoryMap.put("name", "Dogs");

        ArrayList<String> photoUrlList = new ArrayList<String>();
        photoUrlList.add("dummyPhotoURL");

        HashMap<String, String> tag = new HashMap<String, String>();
        tag.put("id", "0");
        tag.put("name", "dummyTagNAme");

        ArrayList<HashMap<String, String>> tags = new ArrayList<HashMap<String, String>>();
        tags.add(tag);

        pet.setId(String.valueOf(petID));
        pet.setName("Updated" + fake.name().firstName());
        pet.setCategory(categoryMap);
        pet.setPhotoUrls(photoUrlList);
        pet.setTags(tags);
        pet.setStatus("available");

        return pet;
    }
    public PetP petCreationData()
    {
        HashMap<String,String> categoryMap = new HashMap<String, String>();
        categoryMap.put("id","1");
        categoryMap.put("name","Dogs");

        ArrayList<String> photoUrlList = new ArrayList<String>();
        photoUrlList.add("dummyPhotoURL");

        HashMap<String,String> tag = new HashMap<String, String>();
        tag.put("id","0");
        tag.put("name","dummyTagNAme");

        ArrayList<HashMap<String,String>> tags = new ArrayList<HashMap<String,String>>();
        tags.add(tag);

        pet.setId(fake.number().digit());
        pet.setName(fake.name().firstName());
        pet.setCategory(categoryMap);
        pet.setPhotoUrls(photoUrlList);
        pet.setTags(tags);
        pet.setStatus("available");

        return pet;
    }
    public PetP existingPetUpdateData(int petID)
    {
        pet = new PetP();
        HashMap<String,String> categoryMap = new HashMap<String, String>();
        categoryMap.put("id","1");
        categoryMap.put("name","Dogs");

        ArrayList<String> photoUrlList = new ArrayList<String>();
        photoUrlList.add("dummyPhotoURL");

        HashMap<String,String> tag = new HashMap<String, String>();
        tag.put("id","0");
        tag.put("name","dummyTagNAme");

        ArrayList<HashMap<String,String>> tags = new ArrayList<HashMap<String,String>>();
        tags.add(tag);

        pet.setId(String.valueOf(petID));
        pet.setName(fake.name().firstName()+"Updated");
        pet.setCategory(categoryMap);
        pet.setPhotoUrls(photoUrlList);
        pet.setTags(tags);
        pet.setStatus("available");
        return pet;
    }
}
